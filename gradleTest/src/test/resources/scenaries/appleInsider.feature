Feature: Тест кейс для сайта appleInsider.ru
  Background: Я нахожусь на главном странице сайта
    Given Открываем сайт "https://appleinsider.ru/"

  Scenario: Заходим на главную страницу, вбиваем в поиск фразу и обрабатываем полученные данные
    When Открываем поиск
    And Вбиваем в поиск нужную фразу
    And Кликаем на поиск
    And Переходим на страницу с результатами поиска
    Then Обрабатываем полученные данные
