package pl.pkrysztofiak.common;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Series {

    private final Property<String> seriesInstanceUID = new SimpleObjectProperty<>();
    private final Property<Integer> seriesNumber = new SimpleObjectProperty<>();
    private final Property<ObservableList<Tag>> tags = new SimpleObjectProperty<>();

    public Series(String seriesInstanceUID, int seriesNumber, Tag... tags) {
        this.seriesInstanceUID.setValue(seriesInstanceUID);
        this.seriesNumber.setValue(seriesNumber);
        this.tags.setValue(FXCollections.observableArrayList(tags));
    }

    public Property<String> seriesInstanceUIDProperty() {
        return seriesInstanceUID;
    }

    public Property<Integer> seriesNumberProperty() {
        return seriesNumber;
    }

    public Property<ObservableList<Tag>> tagsProperty() {
        return tags;
    }
}