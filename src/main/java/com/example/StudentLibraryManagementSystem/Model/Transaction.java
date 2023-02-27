package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus transactionStatus;
//    @Column(name = "tran_Id")
    private String transactionId = UUID.randomUUID().toString();
    @Column(name = "tran_date")
    private LocalDate transactionTime = LocalDate.now();
    @Column(name = "without_fine_date")
    private LocalDate lastDateOfReturnWithoutFine = transactionTime.plusDays(15); //auto
    private int fine;
    @Column(name = "isIssue")
    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    private Card card; //One card can make so many transactions. from transaction perspective,
                      // it will be ManyToOne
    @ManyToOne      //for one book there will be many transactions. from transaction perspective,
    @JoinColumn     //it will be ManyToOne
    private Book book;

}
