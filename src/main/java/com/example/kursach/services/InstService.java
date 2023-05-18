package com.example.kursach.services;

import com.example.kursach.models.Bucket;
import com.example.kursach.models.Image;
import com.example.kursach.models.Instrument;
import com.example.kursach.models.User;
import com.example.kursach.repositories.InstRepository;
import com.example.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstService {
    private final InstRepository instRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BucketServiceImpl bucketService;

    public List<Instrument> listReturn(String instName, Long idCateg, Double minPrice,
                                       Double maxPrice, boolean sortByName, boolean sortByPrice) {
        if (sortByName & sortByPrice) {
            return instRepository.findAllByIdCategOrderByInstNameAscInstPriceAsc(idCateg);
        } else {
            if (sortByName) return instRepository.findAllByIdCategOrderByInstName(idCateg);
            if (sortByPrice) return  instRepository.findAllByIdCategOrderByInstPrice(idCateg);
        }
        if (minPrice!=null | maxPrice!=null){
            return instRepository.findAllByInstPriceBetweenAndIdCateg(minPrice, maxPrice, idCateg);
        }
        if (instName != null) return instRepository.findByInstName(instName);
        return instRepository.findAllByIdCateg(idCateg);
    }

    public void saveInst(Principal principal, Instrument newInst, MultipartFile file1, MultipartFile file2, MultipartFile file3, boolean isEdit) throws IOException {
        newInst.setUser(getUserByPrincipal(principal));

        if (!isEdit) newInst.setIdInst(instRepository.findTopByOrderByIdInstDesc().getIdInst() + 1);

        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            newInst.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            newInst.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            newInst.addImageToProduct(image3);
        }

        //todo check for invalid entries + error message if so, no saving
        log.info("Saving new Instrument. Title:{}, Author email:{}", newInst.getInstName(), newInst.getUser().getUserEmail());

        Instrument instFromDb = instRepository.save(newInst);
        if ((file1.getSize() != 0) | (file2.getSize() != 0) | (file3.getSize() != 0))
            instFromDb.setPreviewImageId(instFromDb.getImages().get(0).getIdImg());
        instFromDb.setDateOfCreated(LocalDateTime.now());
        instRepository.save(instFromDb);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByUserEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImgName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setImgContentType(file.getContentType());
        image.setImgSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void delInst(Long instId) {
        instRepository.deleteById(instId);
    }

    public Instrument getInstByID(Long instId) {
        return instRepository.findById(instId).orElse(null);
    }

    public void addOrRemoveToUserBucket(Long idInst, String userEmail, boolean add, Long idInstToRemove) {
        User userNew = userService.findByUserEmail(userEmail);
        if (userNew == null) throw new RuntimeException("User not found - " + userEmail);

        Bucket bucket = userNew.getBucket();
        if (bucket == null) {
            Bucket newBucket = bucketService.createBucket(userNew, Collections.singletonList(idInst));
            userNew.setBucket(newBucket);
            userRepository.save(userNew);
        } else {
            if (add) {
                bucketService.addOrRemoveInstruments(bucket, Collections.singletonList(idInst), true, null);
            } else {
                bucketService.addOrRemoveInstruments(bucket, Collections.singletonList(idInst), false, idInstToRemove);
            }
        }
    }
}
