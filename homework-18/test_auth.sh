#!/bin/bash

echo "=== ТЕСТ АУТЕНТИФИКАЦИИ ==="
echo ""
echo "Подключаемся к серверу и вводим: admin / admin"
echo ""

(
  sleep 1
  echo "admin"
  sleep 1
  echo "admin"
  sleep 1
  echo "Привет из теста!"
  sleep 1
  echo "/exit"
) | java -cp . ru.otus.chat.client.ClientApp
