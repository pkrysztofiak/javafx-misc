package pl.pkrysztofiak.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.pkrysztofiak.common.Series;
import pl.pkrysztofiak.common.Tag;

public class TableViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Series> seriesList = FXCollections.observableArrayList(
                new Series("1.3.46.670581", 1, new Tag("Of interest"), new Tag("For surgery")),
                new Series("1.3.46.670582", 2, new Tag("Of therapy"), new Tag("For surgery"), new Tag("For peer review")),
                new Series("1.3.46.670583", 3, new Tag("Of research"))
        );

        TableView<Series> tableView = new TableView<>(seriesList);

        TableColumn<Series, String> seriesInstanceUIDColumn = new TableColumn<>("Uid");
        TableColumn<Series, Integer> seriesNumberColumn = new TableColumn<>("Number");
        TableColumn<Series, ObservableList<Tag>> tagsColumn = new TableColumn<>("Tags");

        tableView.getColumns().setAll(seriesInstanceUIDColumn, seriesNumberColumn, tagsColumn);

        seriesInstanceUIDColumn.setCellValueFactory(param -> param.getValue().seriesInstanceUIDProperty()); //param
        seriesNumberColumn.setCellValueFactory(param -> param.getValue().seriesNumberProperty());

        tagsColumn.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().tagsProperty());
        tagsColumn.setCellFactory(column -> new TagsCell());

        primaryStage.setScene(new Scene(tableView));
        primaryStage.show();
    }
}