//package edu.icet.dto;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//public class Demo {
//    private Integer petId;
//
//    @NotBlank(message = "Pet name is required")
//    @Size(min = 2, max = 50, message = "Pet name must be between 2 and 50 characters")
//    private String petName;
//
//    @NotNull(message = "Age is required")
//    @Min(value = 0, message = "Age must be a positive number")
//    @Max(value = 100, message = "Age must be less than or equal to 100")
//    private Integer age;
//
//    @NotBlank(message = "Gender is required")
//    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be 'Male', 'Female', or 'Other'")
//    private String gender;
//
//    @Size(max = 200, message = "Remarks must not exceed 200 characters")
//    private String remarks;
//
//    @NotBlank(message = "Pet type is required")
//    @Size(min = 3, max = 30, message = "Pet type must be between 3 and 30 characters")
//    private String petType;
//
//    @NotBlank(message = "Owner ID is required")
//    @Pattern(regexp = "^(?:\\d{9}[vVxX]|\\d{12})$", message = "Invalid Owner NIC format")
//    private String ownerId;
//}
