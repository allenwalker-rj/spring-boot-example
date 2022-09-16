package com.allen.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author allen
 * @date 2022/9/16 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food implements Serializable {

    private static final long serialVersionUID = -5032586856365373188L;

    private Long id;
    private String name;
    private String color;
}
