package sda.project.admin.service;

import sda.project.admin.model.Company;
import sda.project.admin.model.Employee;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    void saveCompany(Company company);

    Company getCompanyById(long id);

    void deleteCompanyById(long id);


}
