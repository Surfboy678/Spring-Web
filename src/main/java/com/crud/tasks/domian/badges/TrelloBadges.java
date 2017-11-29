package com.crud.tasks.domian.badges;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloBadges {
    private int votes;
    private AttachmentByType attachment;
}
