# Java E-Commerce Console Application

A simple **console-based e-commerce application** built with **Core Java**.  
Users can register, log in, browse products, add items to a cart, and place orders – all from the terminal.

---

## 🧾 Features

- 👤 **User Registration & Login**
  - Register new users
  - Login with username and password

- 🛍️ **Product Catalog**
  - View a list of available products
  - Each product has ID, name, price, and stock

- 🧺 **Shopping Cart**
  - Add products to cart by ID and quantity
  - View all items in the cart
  - Automatic total price calculation

- ✅ **Checkout**
  - Display order summary
  - Show customer name, items, and total amount
  - Clear cart after successful checkout

- 🧱 **Clean Object-Oriented Design**
  - Separate classes for `Product`, `User`, `CartItem`, `DataStore`, `StoreService`, and `Main`

---

## 🛠️ Tech Stack

- **Language:** Java (Core Java, OOP, Collections)
- **Tools:** VS Code, Java Extension Pack
- **JDK Version:** 17+

---

## 📂 Project Structure

```text
ecommerce-console-app/
└── src/
    └── com/
        └── ecommerce/
            ├── Main.java
            ├── StoreService.java
            ├── DataStore.java
            ├── Product.java
            ├── User.java
            └── CartItem.java
