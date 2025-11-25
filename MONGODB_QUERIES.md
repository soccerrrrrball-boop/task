# MongoDB Queries for Product Collection

This document contains MongoDB queries for the product collection based on the product.json file.

## Setup Instructions

1. **Import the JSON file into MongoDB:**
```bash
mongoimport --db your_database_name --collection products --file product.json --jsonArray
```

2. **Connect to MongoDB:**
```bash
mongosh
use your_database_name
```

## Queries

### 1. Find all the information about each products
```javascript
db.products.find({})
```
Returns all documents in the products collection.

---

### 2. Find the product price which are between 400 to 800
```javascript
db.products.find({
    product_price: { $gte: 400, $lte: 800 }
})
```
Returns products with price between 400 and 800 (inclusive).

---

### 3. Find the product price which are not between 400 to 600
```javascript
db.products.find({
    product_price: { $not: { $gte: 400, $lte: 600 } }
})
```
Returns products with price less than 400 or greater than 600.

**Alternative:**
```javascript
db.products.find({
    $or: [
        { product_price: { $lt: 400 } },
        { product_price: { $gt: 600 } }
    ]
})
```

---

### 4. List the four product which are greater than 500 in price
```javascript
db.products.find({
    product_price: { $gt: 500 }
}).limit(4)
```
Returns first 4 products with price greater than 500.

---

### 5. Find the product name and product material of each products
```javascript
db.products.find(
    {},
    { product_name: 1, product_material: 1, _id: 0 }
)
```
Returns only product_name and product_material fields (excludes _id).

---

### 6. Find the product with a row id of 10
```javascript
db.products.find({ id: "10" })
```
Returns the product with id "10" (Note: id is stored as string in the JSON).

---

### 7. Find only the product name and product material
```javascript
db.products.find(
    {},
    { product_name: 1, product_material: 1, _id: 0 }
)
```
Same as query 5 - returns only product_name and product_material.

---

### 8. Find all products which contain the value of soft in product material
```javascript
db.products.find({
    product_material: /soft/i
})
```
Returns products where product_material contains "soft" (case-insensitive).

**Alternative (case-sensitive):**
```javascript
db.products.find({
    product_material: "Soft"
})
```

---

### 9. Find products which contain product color indigo and product price 492.00
```javascript
db.products.find({
    product_color: /indigo/i,
    product_price: 492.00
})
```
Returns products with color containing "indigo" and price exactly 492.00.

---

### 10. Delete the products which product price value are 28
```javascript
db.products.deleteMany({
    product_price: 28
})
```
**Warning:** This permanently deletes all products with price 28.

**To preview what will be deleted:**
```javascript
db.products.find({ product_price: 28 })
```

---

## MongoDB Operators Used

- `$gte`: Greater than or equal to
- `$lte`: Less than or equal to
- `$gt`: Greater than
- `$lt`: Less than
- `$not`: Not operator
- `$or`: Logical OR
- `/pattern/i`: Regular expression (case-insensitive)
- `.limit(n)`: Limits the number of results
- `.pretty()`: Formats output in readable format

## Notes

- The `id` field in the JSON is stored as a string, so use `"10"` not `10` when querying by id
- Product prices are stored as numbers (e.g., 492.00, 28.00)
- Use case-insensitive regex (`/pattern/i`) for flexible string matching
- Always test delete operations with `find()` first before executing `deleteMany()`

