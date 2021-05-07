package com.example.prohelpr.workers;

public class WorkersPojoModel {


    String worker_role;
    String worker_name;
    String worker_number;
    String worker_mail;
    String worker_address;
    String worker_plase;
    String worker_catergory;
    String worker_postalCode;
    String worker_chargeOfWork;
    String worker_avalbiltyStatus;

    public WorkersPojoModel() {
    }

    public WorkersPojoModel(String worker_role, String worker_name, String worker_number, String worker_mail, String worker_address, String worker_plase, String worker_catergory, String worker_postalCode, String worker_chargeOfWork, String worker_avalbiltyStatus) {
        this.worker_role = worker_role;
        this.worker_name = worker_name;
        this.worker_number = worker_number;
        this.worker_mail = worker_mail;
        this.worker_address = worker_address;
        this.worker_plase = worker_plase;
        this.worker_catergory = worker_catergory;
        this.worker_postalCode = worker_postalCode;
        this.worker_chargeOfWork = worker_chargeOfWork;
        this.worker_avalbiltyStatus = worker_avalbiltyStatus;
    }

    public String getWorker_role() {
        return worker_role;
    }

    public void setWorker_role(String worker_role) {
        this.worker_role = worker_role;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(String worker_number) {
        this.worker_number = worker_number;
    }

    public String getWorker_mail() {
        return worker_mail;
    }

    public void setWorker_mail(String worker_mail) {
        this.worker_mail = worker_mail;
    }

    public String getWorker_address() {
        return worker_address;
    }

    public void setWorker_address(String worker_address) {
        this.worker_address = worker_address;
    }

    public String getWorker_plase() {
        return worker_plase;
    }

    public void setWorker_plase(String worker_plase) {
        this.worker_plase = worker_plase;
    }

    public String getWorker_catergory() {
        return worker_catergory;
    }

    public void setWorker_catergory(String worker_catergory) {
        this.worker_catergory = worker_catergory;
    }

    public String getWorker_postalCode() {
        return worker_postalCode;
    }

    public void setWorker_postalCode(String worker_postalCode) {
        this.worker_postalCode = worker_postalCode;
    }

    public String getWorker_chargeOfWork() {
        return worker_chargeOfWork;
    }

    public void setWorker_chargeOfWork(String worker_chargeOfWork) {
        this.worker_chargeOfWork = worker_chargeOfWork;
    }

    public String getWorker_avalbiltyStatus() {
        return worker_avalbiltyStatus;
    }

    public void setWorker_avalbiltyStatus(String worker_avalbiltyStatus) {
        this.worker_avalbiltyStatus = worker_avalbiltyStatus;
    }


}
