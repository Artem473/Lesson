package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.daoiml.Clientdaoiml;
import ru.sapteh.model.Client;


import java.util.Date;
import java.util.List;

public class ClientController {

    @FXML
    private TableView<Client> tableViewClient;

    @FXML
    private TableColumn<Client, Integer> idColumn;

    @FXML
    private TableColumn<Client, String> lastNameColumn;

    @FXML
    private TableColumn<Client, String> firstNameColumn;

    @FXML
    private TableColumn<Client, String> patronymicColumn;

    @FXML
    private TableColumn<Client, Character> genderCodeColumn;

    @FXML
    private TableColumn<Client, Date> birthDayColumn;

    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private TableColumn<Client, Date> registrationDateColumn;

    @FXML
    private TableColumn<Client, String> emailColumn;


    private final ObservableList<Client> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        initDataFromDatabase();
        initTableView();
    }
    private void initDataFromDatabase(){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();


        Dao<Client, Integer> clientDaoImpl = new Clientdaoiml(factory);

        List<Client> listClientsFromDatabase = clientDaoImpl.findByAll();
        observableList.addAll(listClientsFromDatabase);

    }
    private void initTableView(){

        idColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getId()));
        genderCodeColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getGender().getCode()));
        lastNameColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getLastName()));
        firstNameColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getFirstname()));
        patronymicColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getPatronymic()));
        emailColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getEmail()));
        birthDayColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getBirthDay()));
        phoneColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getPhone()));
        registrationDateColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getRegistrationDate()));

        tableViewClient.setItems(observableList);
    }
}