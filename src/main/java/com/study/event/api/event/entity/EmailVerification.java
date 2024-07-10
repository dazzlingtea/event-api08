package com.study.event.api.event.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="tbl_email_verification")
public class EmailVerification {

    @Id
    @GenericGenerator(strategy = "uuid2", name = "uuid-generator")
    @GeneratedValue(generator = "uuid-generator")
    @Column(name="verification_id")
    private String id;

    @Column(nullable=false)
    private String verificationCode; // 인증 코드

    @Column(nullable=false)
    private LocalDateTime expiryDate; // 인증 만료시간

    @OneToOne
    @JoinColumn(name = "event_user_id", referencedColumnName = "ev_user_id")
    private EventUser eventUser;

}
