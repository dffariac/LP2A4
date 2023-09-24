package br.edu.ifsp.restaurante.dto.order;

import java.util.List;

public record OrderRequest(String description,
                           Long client,
                           List<Long> meals) {
}
