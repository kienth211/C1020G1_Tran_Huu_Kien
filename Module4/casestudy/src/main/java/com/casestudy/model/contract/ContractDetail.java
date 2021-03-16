//package com.casestudy.model.contract;
//
//import com.casestudy.model.employee.Employee;
//import org.springframework.stereotype.Controller;
//
//import javax.persistence.*;
//
//@Entity
//public class ContractDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer contractDetailId;
//
//    private String contractDetailQuantity;
//
//    @ManyToOne
//    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
//    private Contract contract;
//
//    @ManyToOne
//    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
//    private AttachService attachService;
//
//    public Integer getContractDetailId() {
//        return contractDetailId;
//    }
//
//    public void setContractDetailId(Integer contractDetailId) {
//        this.contractDetailId = contractDetailId;
//    }
//
//    public String getContractDetailQuantity() {
//        return contractDetailQuantity;
//    }
//
//    public void setContractDetailQuantity(String contractDetailQuantity) {
//        this.contractDetailQuantity = contractDetailQuantity;
//    }
//
//    public Contract getContract() {
//        return contract;
//    }
//
//    public void setContract(Contract contract) {
//        this.contract = contract;
//    }
//
//    public AttachService getAttachService() {
//        return attachService;
//    }
//
//    public void setAttachService(AttachService attachService) {
//        this.attachService = attachService;
//    }
//}
