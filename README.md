# Nimap Machine Test

This is a Spring Boot application that implements CRUD operations for `Category` and `Product` entities, utilizing JPA and Hibernate for database interaction. The project includes REST APIs with server-side pagination, and establishes a one-to-many relationship between `Category` and `Product`.

## Key Features

- **Category and Product CRUD operations** with required REST API endpoints.
- **One-to-many relationship** between `Category` and `Product` (one category can have multiple products).
- **Server-side pagination** for both `Category` and `Product` data.
- When fetching a `Product` by ID, the response includes the corresponding `Category` details.

## Technologies Used

- **Spring Boot**: The core framework for the application.
- **JPA & Hibernate**: For database interaction and ORM.
- **MySQL**: Relational database for storing data.

## API Endpoints

### Category APIs

1. **GET** `/api/categories?page={page}`
   - Fetch all categories with server-side pagination.
   
2. **POST** `/api/categories`
   - Create a new category.
   
3. **GET** `/api/categories/{id}`
   - Fetch a category by its ID.
   
4. **PUT** `/api/categories/{id}`
   - Update a category by its ID.
   
5. **DELETE** `/api/categories/{id}`
   - Delete a category by its ID.

### Product APIs

1. **GET** `/api/products?page={page}`
   - Fetch all products with server-side pagination.
   
2. **POST** `/api/products`
   - Create a new product.
   
3. **GET** `/api/products/{id}`
   - Fetch a product by its ID, along with the respective category details.
   
4. **PUT** `/api/products/{id}`
   - Update a product by its ID.
   
5. **DELETE** `/api/products/{id}`
   - Delete a product by its ID.

## Database Configuration

- The project uses **MySQL** as the relational database.
- **JPA and Hibernate** are used for data persistence and managing entities.
  
## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/sarvesh-0/Nimap_Machine_Test.git
