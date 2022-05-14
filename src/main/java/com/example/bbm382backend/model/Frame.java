package com.example.bbm382backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "frames")
public class Frame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frame_id")
    private BigInteger frameId;

    @Column(name = "post_id")
    private BigInteger postId;

    @Column(name = "frame_path")
    private String framePath;


}
