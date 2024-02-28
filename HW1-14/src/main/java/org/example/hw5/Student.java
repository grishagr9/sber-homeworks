package org.example.hw5;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{

    private int graduate;

    public void nextLevel(){
        graduate++;
    }

}
