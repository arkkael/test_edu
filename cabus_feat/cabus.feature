﻿# language: ru
@cabus
Функционал: cabus

@cabus.cadftcac
Сценарий: Проверка данных контракта и клиента
Если Пользователь заходит на вебсервис cabus для проверки данных контракта и клиента
И Пользователь выбирает меню карт
И Пользователь выбирает свои варинты для фильтрации
И Драйвер сохраняет параметры клиента в cabus
И Пользователь заходит в информацию о клиенте
И Драйвер сохраняет параметры клиента в CIF
И Сравниваются параметры

@cabus.sec
Сценарий: Поиск существующих контрактов
Если Пользователь заходит на вебсервис cabus для поиска контрактов
И Пользователь заходит в меню карт
И Пользователь выбирает свои параметры для фильтрации
И Происходит фильтрация данных
И Пользователь выбирает контракт

@cabus.oab
Сценарий: Открытие всех менюшек
Если Пользователь входит в сервис cabus для проверки всех менюшек
И Пользователь выбирает меню Approved Authorizations
И Пользователь выбирает меню Base24 messages
И Пользователь выбирает меню Presentments
И Пользователь выбирает меню Held presentments
И Пользователь выбирает меню Chargebacks
И Пользователь выбирает меню Fee collections
И Пользователь выбирает меню Cards
И Пользователь выбирает меню GPE reports, а затем EVPK reports
И Пользователь выбирает меню GPE reports, а затем EMPK reports
И Пользователь выбирает меню GPE reports, а затем UCTY reports
И Пользователь выбирает меню GPE reports, а затем Requests history
И Пользователь выбирает меню Card types

@cabus.as
Сценарий: Поиск авторизаций
Если Пользователь заходит на вебсервис для поиска авторизаций
Когда Пользователь вводит правильные данные для входа
И Пользователь идет в меню поиска авторизаций
И Юзер вставляет свои значения
И Данные юзера фильтруются