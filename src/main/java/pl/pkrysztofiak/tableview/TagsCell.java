package pl.pkrysztofiak.tableview;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import pl.pkrysztofiak.common.Series;
import pl.pkrysztofiak.common.Tag;

import java.util.Optional;

public class TagsCell extends TableCell<Series, ObservableList<Tag>> {

    private static int idGenerator = 0;
    private final int id = idGenerator++;

    private final Button cellRoot = new Button();

    //optymalizacja wyświetlania
    public TagsCell() {
        System.out.println("TagsCell(id=" + id + ")");

        itemProperty().addListener((observable, oldValue, observableList) -> {
            if (observableList != null) {
                cellRoot.setText(String.valueOf(observableList.size()));
            }
        });

        emptyProperty().addListener((observable, oldValue, empty) -> {
            setGraphic(empty ? null : cellRoot);
        });
    }
}