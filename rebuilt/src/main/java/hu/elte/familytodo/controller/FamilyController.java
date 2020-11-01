package hu.elte.familytodo.controller;

import hu.elte.familytodo.model.Family;

import hu.elte.familytodo.model.Task;
import hu.elte.familytodo.model.User;
import hu.elte.familytodo.repository.FamilyRepository;
import hu.elte.familytodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/families")
public class FamilyController {

    private FamilyRepository familyRepository;
    private UserRepository userRepository;

    public FamilyController(@Autowired FamilyRepository familyRepository, @Autowired UserRepository userRepository)
    { this.familyRepository = familyRepository;
      this.userRepository = userRepository;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Family>> getFamily(@RequestParam(required = false) String title) {
        Iterable<Family> families;
        families = familyRepository.findAll();
        return ResponseEntity.ok(families);
    }

    @GetMapping("{familyId}/users")
    public ResponseEntity<Iterable<User>> getUsers(@PathVariable Integer familyId) {
        Optional<Family> families = familyRepository.findById(familyId);
        if (families.isPresent()) {
            return ResponseEntity.ok(families.get().getUsers());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Family> postFamily(@RequestBody Family family) {
        Family savedUser = familyRepository.save(family);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/{id}/users")
    public ResponseEntity<User> postUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            Family family = oFamily.get();
            user.setFamily(family);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Family> put(@RequestBody Family family, @PathVariable Integer id) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            family.setId(id);
            return ResponseEntity.ok(familyRepository.save(family));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Family> oFamily = familyRepository.findById(id);
        if (oFamily.isPresent()) {
            familyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
