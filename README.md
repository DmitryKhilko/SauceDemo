<html>
  <body>
   <h1>Обновление версий библиотек в проекте</h1>
        <p> Ввести команду в окне терминала для проверки новых версий библиотек:  mvn versions:display-dependency-updates</p>
        <p> Получим результат выполнения команды:</p>
        <p> [INFO] The following dependencies in Dependencies have newer versions:</p>
        <p> [INFO]   io.github.bonigarcia:webdrivermanager ................. 5.0.0 -> 5.0.3</p>
        <p> [INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.1.1</p>
        <p> [INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0</p>
        <p> При необходимости обновить версии библиотек введите в окне терминала команду: mvn versions:use-latest-versions</p>

   <h1>Запуск тестов с помощью Mavev</h1>
        <p> Ввести команду в окне терминала для запуска тестов:   mvn clean test -Dtest=LoginPageTest -DtestProp=secret_sauce</p>
        <p> Получим результат выполнения тестов:  </p>
        <p> Results :</p>
        <p> Tests run: 5, Failures: 0, Errors: 0, Skipped: 0</p>
        <p> [INFO] ------------------------------------------------------------------------</p>
        <p> [INFO] BUILD SUCCESS</p>
        <p> [INFO] ------------------------------------------------------------------------</p>
        <p> [INFO] Total time:  21.989 s</p>
        <p> [INFO] Finished at: 2021-12-24T01:27:08+03:00</p>
        <p> [INFO] ------------------------------------------------------------------------</p>
   
   <h1>Запуск тестов с помощью Mavev из файла regression.xml с передачей параметра в один из тестов</h1>
        <p> Ввести команду в окне терминала для запуска тестов:  mvn clean test -DtestProp=secret_sauce -DsuiteXmlFile='src/test/resources/regression.xml'</p>
        <p> где -DtestProp=secret_sauce - параметр (пароль), передаваемый в тест loginCorrectUsernameCorrectPassword()</p>
        <p> Получим результат выполнения тестов:  </p>
        <p> Results :</p>
        <p>  Tests run: 15, Failures: 0, Errors: 0, Skipped: 0</p>
        <p> [INFO] ------------------------------------------------------------------------</p>
        <p> [INFO] BUILD SUCCESS</p>
        <p> [INFO] ------------------------------------------------------------------------</p>
        <p> [INFO] Total time:  38.395 s s</p>
        <p> [INFO] Finished at: 2021-12-24T22:47:05+03:00</p>
        <p> [INFO] ------------------------------------------------------------------------</p>

   <h1>Чек лист для приложения www.saucedemo.com</h1>  
      <h2>Страница LoginPage</h2>
        <p>1. *Войти в интернет-магазин с коректными логином и паролем</p>
        <p>2. *Войти в интернет-магазин с пустым логином и корректным паролем</p>
        <p>3. *Войти в интернет-магазин с корректным логином и пустым паролем</p>
        <p>4. *Войти в интернет-магазин с не корректными логином и паролем</p>
        <p>5. *Войти в интернет-магазин с логином заблокированного пользователя и коректным паролем</p>
      <h2>Меню приложения BurgerMenu</h2>
        <p>6. *Убедится в наличии BurgerMenu на странице "PRODUCTS" и его работоспособности (открыть меню)</p>
        <p>7. Убедится в наличии BurgerMenu на странице InventoryItemPage и его работоспособности (открыть меню)</p>
        <p>8. Убедится в наличии BurgerMenu на странице "YOUR CART" и его работоспособности (открыть меню)</p>
        <p>9. Убедится в наличии BurgerMenu на странице "CHECKOUT: YOUR INFORMATION" и его работоспособности (открыть меню)</p>
        <p>10. Убедится в наличии BurgerMenu на странице "CHECKOUT: OVERVIEW" и его работоспособности (открыть меню)</p>
        <p>11. Убедится в наличии BurgerMenu на странице "CHECKOUT: COMPLETE!" и его работоспособности (открыть меню)</p>
        <p>12. Проверить работоспособности пункта меню "ALL ITEMS"</p>
        <p>13. Проверить работоспособности пункта меню "ABOUT"</p>
        <p>14. Проверить работоспособности пункта меню "RESET APP STATE"</p>
        <p>15. *Проверить работоспособности пункта меню "LOGOUT"</p>
      <h2>Страница InventoryPage</h2>
        <p>16. *Отсортировать товары страницы NAME (A TO Z)</p>
        <p>17. *Отсортировать товары страницы NAME (Z TO A)</p>
        <p>18. *Отсортировать товары страницы PRICE (LOW TO HIGH)</p>
        <p>19. *Отсортировать товары страницы PRICE (HIGH TO LOW)</p>
        <p>20. *Добавить три разных товара в корзину и убедится, что они присутствуют в корзине </p>
        <p>21. *Убедиться, что на иконке корзины отобразилась цифра 3 </p>
        <p>22. Убрать один товар из корзины с текущей страницы и убедится, что он удален из корзины </p>
        <p>23. Убедиться, что на иконке корзины отобразилась цифра 2 </p>
        <p>24. Убедиться, при нажатии кнопки "ADD TO CART" (красного цвета) кнопка меняет название на "REMOVE" (черного цвета)</p>
        <p>25. Убедиться, придобавлении товара на странице InventoryItemPage кнопка "ADD TO CART" (красного цвета) странцы InventoryPage изменилась на "REMOVE" (черного цвета)</p>
      <h2>Страница InventoryItemPage</h2>
        <p>26. Выбрать товар на странице "PRODUCTS" для просмотра</p>
        <p>27. Положить выбранный товар в корзину и убедится, что он попал в корзину</p>
        <p>28. Убедиться, при нажатии кнопки "ADD TO CART" (красного цвета) кнопка меняет название на "REMOVE" (черного цвета)</p>
        <p>29. Убедиться, что на иконке корзины появилась цифра или увеличилась имеющаяся цифра</p>
        <p>30. Убрать выбранный товар из корзины с текущей страницы и убедится, что он убран из корзины</p>
        <p>31. Убедиться, что на иконке корзины цифра пропала или уменьшилась имеющаяся цифра</p>
        <p>32. Вернуться на страницу "PRODUCTS" с помощью кнопки "BACK TO PRODUCTS"</p>    
      <h2>Страница CartPage</h2>
        <p>33. *Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице "PRODUCTS" и ее работоспособности (перейти в корзину)</p>
        <p>34. Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице InventoryItemPage и ее работоспособности (перейти в корзину)</p>
        <p>35. Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице "YOUR CART" и ее работоспособности (перейти в корзину)</p>
        <p>36. Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице "CHECKOUT: YOUR INFORMATION" и ее работоспособности (перейти в корзину)</p>
        <p>37. Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице "CHECKOUT: OVERVIEW" и ее работоспособности (перейти в корзину)</p>
        <p>38. Убедится в наличии ShoppingCartLink (иконки с корзиной) на странице "CHECKOUT: COMPLETE!" и ее работоспособности (перейти в корзину)</p>
        <p>39. Вернуться из корзины на страницу "PRODUCTS" с помощью кнопки "CONTINUE SHOPPING"</p>
        <p>40. Положить в корзину три товара. На странице "YOUR CART" удалить один из них</p>        
        <p>41. Перейти на страницу "CHECKOUT: YOUR INFORMATION" с помощью кнопки "CHECKOUT"</p>
        <p>42. Вернуться со страницы "CHECKOUT: YOUR INFORMATION" обратно на страницу "YOUR CART" с помощью кнопки "CANCEL"</p>
        <p>43. *Удалить все добавленные товары из корзины</p>
      <h2>Страница CheckoutStepOnePage</h2>
        <p>44. Перейти на страницу "CHECKOUT: YOUR INFORMATION"</p>
        <p>45. Нажать кнопку "CONTINUE" (First Name: корректное значение; Last Name: корректное значение; ZIP/Postal code: корректное значение)</p>
        <p>46. Вернуться со страницы "CHECKOUT: OVERVIEW" обратно на страницу "CHECKOUT: YOUR INFORMATION" с помощью кнопки "CANCEL"</p>
        <p>47. Нажать кнопку "CONTINUE" (First Name: пусто; Last Name: пусто; ZIP/Postal code: пусто)</p>
        <p>48. Нажать кнопку "CONTINUE" (First Name: пусто; Last Name: корректное значение; ZIP/Postal code: пусто)</p>
        <p>49. Нажать кнопку "CONTINUE" (First Name: пусто; Last Name: пусто; ZIP/Postal code: корректное значение)</p>
      <h2>Страница CheckoutStepTwoPage</h2>
        <p>50. Перейти на страницу "CHECKOUT: OVERVIEW"</p>
        <p>51. Убедится, что на странице отображены выбранные товары (название и цена)</p>
        <p>52. Убедится, что на странице отображен сформированный номер заказа SauceCard</p>
        <p>53. Провернить правильность расчета Item total</p>
        <p>54. Провернить правильность расчета Total</p>
        <p>55. Нажать на кнопку "FINISH"</p>
      <h2>Страница CheckoutCompletePage</h2>
        <p>56. Убедится, что перешли на страницу "CHECKOUT: COMPLETE!" (название страницы)</p>
        <p>57. Убедится, что заказ оформлен успешно (текст "THANK YOU FOR YOUR ORDER")</p>
        <p>58. Убедится, что корзина пуста и пропало кол-во товара на иконке корзины</p>
        <p>59. Проверить переход на страницу "PRODUCTS" при нажатии кнопки "BACK HOME"</p>        
  </body>
</html> 
 
 












