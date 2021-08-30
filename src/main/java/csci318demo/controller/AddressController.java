package csci318demo.controller;

import csci318demo.model.Address;
import csci318demo.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/addresses")
    List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/addresses/{id}")
    Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/addresses")
    Address createAddress(@RequestBody Address newAddress) {
        return addressRepository.save(newAddress);
    }

}
