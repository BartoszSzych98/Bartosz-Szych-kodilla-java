package com.kodilla.good.patterns.challenges.Allegro;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, LocalDateTime orderTime, LocalDateTime deliveryTime);
}
