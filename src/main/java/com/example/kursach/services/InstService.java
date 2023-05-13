package com.example.kursach.services;

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
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstService {
    private final InstRepository instRepository;
    private final UserRepository userRepository;

    public List<Instrument> listReturn(String instName, Long idCateg) {

        if (instName != null) return instRepository.findByInstName(instName);
        return instRepository.findAllByIdCateg(idCateg);
    }

    public void saveInst (Principal principal, Instrument newInst, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        newInst.setUser(getUserByPrincipal(principal));
        newInst.setIdInst(instRepository.findTopByOrderByIdInstDesc().getIdInst() + 1);

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

    public void delInst (Long instId) {
        instRepository.deleteById(instId);
    }

    public Instrument getInstByID (Long instId){
        return instRepository.findById(instId).orElse(null);
    }
}
