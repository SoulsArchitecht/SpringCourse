package mvc;


import mvc.validation.CheckEmail;

import javax.validation.constraints.*;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "error name size")
    private String name;
    @NotBlank(message = "surname is required field")
    private String surname;
    @Min(value = 500, message = "minimum amount is 500")
    @Max(value = 10000, message = "maximum amount is 10000")
    private int salary;
    private String department; //хардкодед стайл
    private Map<String, String> departments; //чтобы не было жесткой привязки (хардкодед)
    private String carBrand; //хардкодед стайл
    private Map<String, String> carBrands;
    private  String[] languages;
    private Map<String, String> languagesList;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "Pattern should be XXX-XX-XX")
    private String phoneNumber;

    //будут использоваться прописанные а не дефолтные если укажем
    //@CheckEmail(value = "abc.com", message = "email should be ends with abc.com")
    @CheckEmail
    private String email;

    public Employee() {
        departments = new HashMap<>();
        departments.put("IT", "Information Technology");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Audi", "AUDI");
        carBrands.put("Mercedes-Benz", "MB");

        languagesList = new HashMap<>();
        languagesList.put("English", "EN");
        languagesList.put("Deutsch", "DE");
        languagesList.put("Francais", "FR");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}