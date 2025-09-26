package Snapbrief_AI.demo.Service;

import Snapbrief_AI.demo.Entity.CategoryResult;
import Snapbrief_AI.demo.Repo.CategoryResultRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CateSumService {

    private final CategoryResultRepo categoryResultRepo;

    public CateSumService(CategoryResultRepo categoryResultRepo) {
        this.categoryResultRepo = categoryResultRepo;
    }

    // ✅ Delete all
    public void deleteAll() {
        categoryResultRepo.deleteAll();
    }

    // ✅ Delete by ID
    public void deleteById(long id) {
        if (!categoryResultRepo.existsById(id)) {
            throw new NoSuchElementException("Article with id " + id + " not found");
        }
        categoryResultRepo.deleteById(id);
    }

    // ✅ Get all
    public List<CategoryResult> getAll() {
        return categoryResultRepo.findAll();
    }

    // ✅ Get by ID
    public CategoryResult getById(long id) {
        return categoryResultRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article with id " + id + " not found"));
    }
}
