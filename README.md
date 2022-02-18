# SPas
A password manager made in java. I know it's not the most clean looking code, it also isn't the best code. But it works :)
I might update this project. I enjoyed working on it


So what this does is you have to fill in the master password. the master password hashed in sha-512 is the secret key. 
for the password encryption (AES, a symmetric encryption method which means i need 1 secret key)
If the master password is false the decryption won't work because the key is not valid. 
If it's true the decryption will work and you'll see all your valid passwords because the key is valid.

This is a good way of getting the right key without actually storing it.
