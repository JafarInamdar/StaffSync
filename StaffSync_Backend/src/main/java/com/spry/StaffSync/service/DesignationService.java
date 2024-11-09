package com.spry.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spry.StaffSync.model.Designation;
import com.spry.StaffSync.repository.DesignationRepository;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }

    public Optional<Designation> getDesignationById(long id) {
        return designationRepository.findById(id);
    }

    public Designation addDesignation(Designation designation) {
        return designationRepository.save(designation);
    }

    public Designation updateDesignation(long id, Designation designation) {
        Optional<Designation> oldDesignationOptional = designationRepository.findById(id);
        
        if (oldDesignationOptional.isPresent()) {
            Designation oldDesignation = oldDesignationOptional.get();
            oldDesignation.setDesignationTitle(designation.getDesignationTitle());
            oldDesignation.setDesignationDescription(designation.getDesignationDescription());
            oldDesignation.setDesignationLevel(designation.getDesignationLevel());
            return designationRepository.save(oldDesignation); 
        } else {
            
            throw new RuntimeException("Designation not found with id: " + id);
        }
    }

    public void deleteDesignation(long id) {
        if (designationRepository.existsById(id)) {
            designationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Designation not found with id: " + id);
        }
    }
}
