### **Description**

This plugin allows you to set a distance in which players can write to each other, also it is possible to increase this distance if the player holds a certain item in his hand. The item has a custom texture.  
**This Plugin is pretty customizable take a look at the default config file to get a better idea.**

![megaphone item](https://drive.google.com/uc?export=download&id=1zNVJAzF8qmALQfK0lHwY9tTGYZOlvA9c)  

### **Commands**

*   **/global <message>:** Sends a message to all players regardless their distance.
*   **/nearchatreload:** Updates changes made to the config.

  

### **Permissions**

*   **nearchat.global:** Allows the player to use the /global command.
*   **nearchat.reload:** Allows the player to use the /nearchatreload command.

  

### **Default Config:**
```yml
# format --> style of the chat message  
#        --> use <name> for name of sender and <message> for the message  
#        --> important surround with ' even if it isn't is like that by default  
# distance --> distance in blocks a Player can write to others  
# distance_with_item --> distance in blocks a Player can write to others when holding the item that extends their speaking range  
# item.name --> name of the item that extends their speaking range  
# item.description --> the description of the item that extends their speaking range  
# ingredients --> ingredients for crafting recipe of the item that extends the speaking range  
#             --> just change the part after "type:" according to this list https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html  
# texturepack.enable --> enables or disables the custom resource pack  
# texturepack.url --> the url where the resource pack is going to be downloaded from  
#                 --> needs to be an instant download link (the download starts automatically when you open the link without any other steps)  
#                 --> important surround with ' even if it isn't is like that by default  
#                 --> note: if you want to use your own texture just take the original resource pack and replace the image in \assets\minecraft\textures\item\megaphone.png   
# texturepack.filename --> name of the file after download  
  
format: <<name>> <message>  
distance: 10  
distance_with_item: 30  
item:  
  name: Megaphone  
  description: Enables you to talk to players within 30 blocks.  
ingredients:  
  top_left:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: AIR  
  top_center:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: IRON_INGOT  
  top_right:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: AIR  
  middle_left:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: IRON_INGOT  
  middle_center:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: NAUTILUS_SHELL  
  middle_right:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: IRON_INGOT  
  bottom_left:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: AIR  
  bottom_center:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: REDSTONE  
  bottom_right:  
    ==: org.bukkit.inventory.ItemStack  
    v: 2586  
    type: AIR  
texturepack:  
  enable: true  
  url: https://drive.google.com/uc?export=download&id=1mUa_4H2dq3c7ehVfwqZ7neAkD5k6kyJl  
  filename: MegaphoneTexturePack.zip
  ```
