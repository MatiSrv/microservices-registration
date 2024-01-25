package com.project.template.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Event<T> {
    private String id;
    private Date date;
    private EventType type;
    private T data;
}
