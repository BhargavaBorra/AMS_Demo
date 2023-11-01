package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.SupplyDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.model.SupplyID;
import org.iitc.ams_demo.repository.ISupplyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyService {

    private ISupplyRepository supplyRepository;

    public SupplyService(ISupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<SupplyDTO> getSuppliers() {
        List<SupplyDTO> suppliers = new ArrayList<>();
        supplyRepository.findAll().forEach(suppliers::add);
        return suppliers;
    }

    public void addSupplier(SupplyDTO supplier) {
        supplyRepository.save(supplier);
    }

    public void updateSupplier(SupplyDTO supplier) {
//        SupplyDTO existingSupplier = supplyRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + id));
//        if (supplier.getInvoiceNumber() != null)
//            existingSupplier.setInvoiceNumber(supplier.getInvoiceNumber());
//        if (supplier.getSupplyDate() != null)
//            existingSupplier.setSupplyDate(supplier.getSupplyDate());
//        if (supplier.getManufactureYear() != null)
//            existingSupplier.setManufactureYear(supplier.getManufactureYear());
//        if (supplier.getPurchaseDate() != null)
//            existingSupplier.setPurchaseDate(supplier.getPurchaseDate());
//        if (supplier.getSupplyID().getAsset().getAssetId() != null)
//            existingSupplier.setSupplyID(supplier.getSupplyID());
        supplyRepository.save(supplier);
    }

    public void deleteSupplier(SupplyID id) throws ResourceNotFoundException {
        SupplyDTO existingSupplier = supplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + id));
        supplyRepository.delete(existingSupplier);
    }

    public SupplyDTO getSupplierDetails(SupplyID id) throws ResourceNotFoundException {

        return supplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + id));
    }
}
