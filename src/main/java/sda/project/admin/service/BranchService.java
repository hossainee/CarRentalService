package sda.project.admin.service;

import sda.project.admin.model.Branch;


import java.util.List;

public interface BranchService {
    List<Branch> getAllBranch();

    void saveBranch(Branch branch);

    Branch getBranchById(long id);

    void deleteBranchById(long id);

}
