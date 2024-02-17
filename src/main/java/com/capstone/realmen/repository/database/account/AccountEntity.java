package com.capstone.realmen.repository.database.account;

import java.time.LocalDate;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.repository.database.auditable.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountId;
    @Column(name = "branch_id")
    Long branchId;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "phone", nullable = false, unique = true)
    String phone;
    @Column(name = "password")
    String password;
    @Column(name = "staff_code", unique = true)
    String staffCode;
    @Column(name = "role", nullable = false)
    ERole role;
    @Column(name = "thumbnail", columnDefinition = "LONGTEXT")
    String thumbnail;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    LocalDate dob;
    @Column(name = "gender")
    EGender gender;
    @Column(name = "accountStatus")
    EAccountStatus accountStatus = EAccountStatus.ACTIVATED;
}
