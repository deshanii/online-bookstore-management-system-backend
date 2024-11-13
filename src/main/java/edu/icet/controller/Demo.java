//package edu.icet.controller;
//
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/pet")
//@RequiredArgsConstructor
//@Slf4j
//public class Demo {
//    final PetService petService;
//
//    @PostMapping("/add-pet")
//    public ResponseEntity<String> addPet(@Valid @RequestBody Pet pet) {
//        log.info("Received request to add Pet: {}", pet);
//        petService.addPet(pet);
//        return ResponseEntity.ok("Pet added successfully");
//    }
//
//    @GetMapping("/pet-get-all")
//    public List<Pet> getPets() {
//        log.info("Received request to retrieve all pets");
//        return petService.getAll();
//    }
//
//    @GetMapping("/pet-search-by-id/{id}")
//    public Pet searchPetsById(@Valid @PathVariable Integer id) {
//        log.info("Searching for Pet by ID: {}", id);
//        return petService.SearchPetById(id);
//    }
//
//    @GetMapping("/pet-search-by-name/{name}")
//    public List<Pet> searchPetsByName(@Valid @PathVariable String name) {
//        log.info("Searching for Pets by Name: {}", name);
//        return petService.searchByName(name);
//    }
//
//    @PutMapping("/pet-update-by-id")
//    public ResponseEntity<String> updatePet(@Valid @RequestBody Pet pet) {
//        log.info("Received request to update Pet: {}", pet);
//        petService.updatePetById(pet);
//        return ResponseEntity.ok("Pet updated successfully");
//    }
//
//    @DeleteMapping("/pet-delete-by-id/{id}")
//    public ResponseEntity<String> deletePet(@Valid @PathVariable Integer id) {
//        log.info("Received request to delete Pet with ID: {}", id);
//        petService.deletePetById(id);
//        return ResponseEntity.ok("Pet deleted successfully");
//    }
//
//    @DeleteMapping("/pet-delete-all")
//    public ResponseEntity<String> deleteAllPets() {
//        log.info("Received request to delete all Pets");
//        petService.deleteAll();
//        return ResponseEntity.ok("All Pets deleted successfully");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        log.error("Validation error: {}", errors);
//        return errors;
//    }
//
//}