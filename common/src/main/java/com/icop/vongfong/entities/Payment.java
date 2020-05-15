package com.icop.vongfong.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 737275066173693741L;

    private Long id;
    private String serial;
}
