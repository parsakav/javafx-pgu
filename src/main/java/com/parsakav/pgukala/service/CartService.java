package com.parsakav.pgukala.service;

import com.parsakav.pgukala.entity.Cart;
import com.parsakav.pgukala.entity.Stuff;
import com.parsakav.pgukala.entity.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class CartService {

    public static HashMap<Cart, Stuff>  carts= new HashMap<>();
    static {
        try(ObjectInputStream objectOutputStream =new ObjectInputStream( Files.newInputStream(Paths.get("carts.dat")));) {
           carts= (HashMap<Cart, Stuff>) objectOutputStream.readObject();

        } catch (IOException e) {
       } catch (ClassNotFoundException e) {
      }

        System.out.println(carts);
    }
    public static void update(){
        try(ObjectOutputStream objectOutputStream =new ObjectOutputStream( Files.newOutputStream(Paths.get("carts.dat")));) {
        objectOutputStream.writeObject(carts);
        objectOutputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
