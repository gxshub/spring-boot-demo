package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Library;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.LibraryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    private final LibraryRepository libraryRepository;
    private final AddressRepository addressRepository;

    // @Autowired
    LibraryController(LibraryRepository libraryRepository, AddressRepository addressRepository) {
        this.libraryRepository = libraryRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/libraries")
    List<Library> all() {
        return libraryRepository.findAll();
    }

    @GetMapping("/libraries/{id}")
    Library one(@PathVariable Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/libraries")
    Library newLibrary(@RequestBody Library newLibrary) {
        return libraryRepository.save(newLibrary);
    }

    @PutMapping("/libraries/{id}/address/{addressId}")
    Library updateLibraryAddress(@PathVariable Long id, @PathVariable Long addressId) {
        Library library = libraryRepository.findById(id).orElseThrow(RuntimeException::new);
        Address address = addressRepository.findById(addressId).orElseThrow(RuntimeException::new);
        library.setAddress(address);
        return libraryRepository.save(library);
    }
}
