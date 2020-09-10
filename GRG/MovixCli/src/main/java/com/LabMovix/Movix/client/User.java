package com.LabMovix.Movix.client;



import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Getter
    @Setter
    private int uid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    String apellido;
    @Getter
    @Setter
    private String utype;
    @Getter
    @Setter
    private String pass;
    @Getter
    @Setter
    private String empr_name;

}
