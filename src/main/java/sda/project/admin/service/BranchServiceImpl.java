package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.Branch;

import sda.project.admin.repository.BranchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public void saveBranch(Branch branch) {
        this.branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(long id) {
        Optional< Branch > optional = branchRepository.findById(id);
        Branch branch = null;
        if (optional.isPresent()) {
            branch = optional.get();
        } else {
            throw new RuntimeException(" Branch not found for id :: " + id);
        }
        return branch;
    }

    @Override
    public void deleteBranchById(long id) {
        this.branchRepository.deleteById(id);
    }


}
