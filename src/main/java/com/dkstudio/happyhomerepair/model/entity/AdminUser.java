package com.dkstudio.happyhomerepair.model.entity;

import com.dkstudio.happyhomerepair.model.enums.AdminUserRoleState;
import com.dkstudio.happyhomerepair.model.enums.AdminUserState;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"blogPostList"})
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String account;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private AdminUserState status;

    @NotNull
    private AdminUserRoleState role;

    private LocalDateTime lastLoginAt;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer loginFailCount;

    private LocalDateTime passwordUpdatedAt;

    @NotNull
    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
    private List<BlogPost> blogPostList;

}
