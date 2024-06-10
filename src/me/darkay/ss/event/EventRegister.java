package me.darkay.ss.event;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.darkay.ss.Constants;
import me.darkay.ss.command.CommandSS;
import me.darkay.ss.util.PlayerData;

public class EventRegister implements Listener
{
    public static final String BACK = "§cRetour", BACK_TO = "§7(vers /ss We're Not Nazi)", CONFIRM = "§2>§f Clic gauche pour appliquer", MESSAGES = "§6Messages", USELESS_MESSAGE = "§6Message inutile", FALSE_INFORMATION = "§6Fausse information", SMS = "§6SMS", WRONG_FORMATTER = "§6Formattage incorrect", VANTARDISE = "§6Vantardise", FLOOD = "§6Flood", BAD_LANGUAGE = "§6Mauvais langage", PROVOCATION = "§6Provocation", INSULT = "§6Insulte", OFFENSE_INCITEMENT = "§6Incitation à l'infraction", CHAT_BYPASS = "§6Coutournement protection chat", FORBIDDEN_LINK = "§6Lien interdit", ADS = "§6Publicité", HACK = "§6DDOS ou Hack/Fake/Phishing", WRONG_USERNAME = "§6Nom d'utilisateur incorrect", THREAT = "§6Menaces (IRL)", GAMEPLAY = "§6Gameplay", ALLY = "§6Alliances en solo", ALLY_1 = "§6Alliances en équipe", BUILD = "§6Construction incorrecte", SKIN = "§6Skin incorrect", ANTI_GAMES = "§6Anti-Jeux", CHEAT = "§6Triche", ANTI_KNOCKBACK = "§6Anti-Knockback", FORCE_FIELD = "§6ForceField/KillAura", TIMER = "§6Timer/FastPlace", REACH = "§6Reach", OTHERS = "§6Autres", CPS = "§6Maccro/JitterClick", CPS_1 = "§6Maccro/JitterClick", FLY = "§6Fly/Glide";
    
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event)
    {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem(), playerSkull = new ItemStack(397, 1, (byte) 3), woodDoor = new ItemStack(Material.WOOD_DOOR), paper = new ItemStack(Material.PAPER), woodenHoe = new ItemStack(Material.WOOD_HOE), glassBottle = new ItemStack(Material.GLASS_BOTTLE), zombieHead = new ItemStack(397, 1, (byte) 2), fish = new ItemStack(349, 1, (byte) 3), diamondSword = new ItemStack(Material.DIAMOND_SWORD), tnt = new ItemStack(Material.TNT), rottenFlesh = new ItemStack(Material.ROTTEN_FLESH), potion = new ItemStack(373, 1, (byte) 16385), creeperHead  = new ItemStack(397, 1, (byte) 4), enderPearl = new ItemStack(Material.ENDER_PEARL), book = new ItemStack(Material.BOOK), ironBars = new ItemStack(Material.IRON_FENCE), banner = new ItemStack(Material.BEDROCK), carrotOnAStick = new ItemStack(Material.CARROT_STICK), nameTag = new ItemStack(Material.NAME_TAG), skeletonHead = new ItemStack(397), ironSword = new ItemStack(Material.IRON_SWORD), clownFish = new ItemStack(349, 1, (byte) 2), rawSalmon = new ItemStack(349, 1, (byte) 1), dirt = new ItemStack(Material.DIRT), leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE), flintAndSteel = new ItemStack(Material.FLINT_AND_STEEL), goldenApple = new ItemStack(Material.GOLDEN_APPLE), cobweb = new ItemStack(Material.WEB), ironSwordCheat = new ItemStack(Material.IRON_SWORD), clock = new ItemStack(Material.WATCH), bow = new ItemStack(Material.BOW), stone = new ItemStack(Material.STONE), ironAxe = new ItemStack(Material.IRON_AXE), diamondAxe = new ItemStack(Material.DIAMOND_AXE), feather = new ItemStack(Material.FEATHER);
        ItemMeta playerSkullMetadata = playerSkull.getItemMeta(), woodDoorMetadata = woodDoor.getItemMeta(), paperMetadata = paper.getItemMeta(), woodenHoeMetadata = woodenHoe.getItemMeta(), glassBottleMetadata = glassBottle.getItemMeta(), zombieHeadMetadata = zombieHead.getItemMeta(), fishMetadata = fish.getItemMeta(), diamondSwordMetadata = diamondSword.getItemMeta(), tntMetadata = tnt.getItemMeta(), rottenFleshMetadata = rottenFlesh.getItemMeta(), potionMetadata = potion.getItemMeta(), creeperHeadMetadata = creeperHead.getItemMeta(), enderPearlMetadata = enderPearl.getItemMeta(), bookMetadata = book.getItemMeta(), ironBarsMetadata = ironBars.getItemMeta(), bannerMetadata = banner.getItemMeta(), carrotOnAStickMetadata = carrotOnAStick.getItemMeta(), nameTagMetadata = nameTag.getItemMeta(), skeletonHeadMetadata = skeletonHead.getItemMeta(), ironSwordMetadata = ironSword.getItemMeta(), clownFishMetadata = clownFish.getItemMeta(), rawSalmonMetadata = rawSalmon.getItemMeta(), dirtMetadata = dirt.getItemMeta(), leatherChestplateMetadata = leatherChestplate.getItemMeta(), flintAndSteelMetadata = flintAndSteel.getItemMeta(), goldenAppleMetadata = goldenApple.getItemMeta(), cobwebMetadata = cobweb.getItemMeta(), ironSwordCheatMetadata = ironSwordCheat.getItemMeta(), clockMetadata = clock.getItemMeta(), bowMetadata = bow.getItemMeta(), stoneMetadata = stone.getItemMeta(), ironAxeMetadata = ironAxe.getItemMeta(), diamondAxeMetadata = diamondAxe.getItemMeta(), featherMetadata = feather.getItemMeta();
        
        if (itemStack == null)
        {
            return;
        }
        
        if (inventory.getName().equalsIgnoreCase(Constants.INVENTORY_SS))
        {            
            event.setCancelled(true);
            
            if (itemStack.getType() == Material.PAPER)
            {
                inventory = Bukkit.createInventory(null, 54, Constants.INVENTORY_MESSAGES);
                
                playerSkullMetadata.setDisplayName("§b" + CommandSS.offlinePlayer);
                playerSkull.setItemMeta(playerSkullMetadata);
                
                paperMetadata.setDisplayName(MESSAGES);
                paper.setItemMeta(paperMetadata);
                
                woodenHoeMetadata.setDisplayName(USELESS_MESSAGE);
                woodenHoeMetadata.setLore(Arrays.asList("§fMessage inutile qui encombre le ", "§fchat sans raison (attention au", "§fcontexte, ne pas sanctionner si ", "§fc'est un délire en un groupe de ", "§fjoueur qui ne dérange pas les", "§fautres !).", "", "§fEx:", "§f'Je suis une licorne'", "§f'Aiulhgmhdsfes'", "", CONFIRM, "§7- /mute:1m"));
                woodenHoe.setItemMeta(woodenHoeMetadata);
                
                glassBottleMetadata.setDisplayName(FALSE_INFORMATION);
                glassBottleMetadata.setLore(Arrays.asList("§fQuand un joueur poste une", "§finformation totalement fausse sans","§fse renseigner ou pour troller.", "", "§fEx:", "§f'Y'a Siphano de connecté' (alors", "§fque c'est faux)", "§f'Le serveur va fermer demain'", "§f'J'étais administrateur avant'", "", CONFIRM, "§7- /mute:3m"));
                glassBottle.setItemMeta(glassBottleMetadata);
                
                zombieHeadMetadata.setDisplayName(SMS);
                zombieHeadMetadata.setLore(Arrays.asList("§fMessage complétement en SMS:", "§fl'auteur fait réellement preuve de", "§fmauvaise volonté pour se faire", "§fcomprendre.", "§fDonc les abrévations ('slt', 'gg',", "§f'qqchose') restent autorisées !", "", "§fEx:", "§f'cc vou alé bi1 ?'", "§f'tu fait koi'", "", CONFIRM, "§7- /mute:1m"));
                zombieHead.setItemMeta(zombieHeadMetadata);
                
                fishMetadata.setDisplayName(WRONG_FORMATTER);
                fishMetadata.setLore(Arrays.asList("§fTentative de mise en avant du", "§fmessage en contournant le système", "§fde protection.", "", "§fEx:", "§f'S.A.L.U.T'", "§f'....===je recrute pour FACTION", "§f!!!!!!! ==== .....'", "", CONFIRM, "§7- /mute:2m"));
                fish.setItemMeta(fishMetadata);
                
                diamondSwordMetadata.setDisplayName(VANTARDISE);
                diamondSwordMetadata.setLore(Arrays.asList("§fUn joueur se vante et rabaisse un", "§fautre.", "", "§fEx:",  "§f'ez'", "§f't'es nul'", "§f'je suis beaucoup plus fort que toi'", "", CONFIRM, "§7- /mute:1m"));
                diamondSword.setItemMeta(diamondSwordMetadata);
                
                tntMetadata.setDisplayName(FLOOD);
                tntMetadata.setLore(Arrays.asList("§fEnvoie de plusieurs messages", "§fsimilaires en peu de temps.", "", "§fEx:", "§f'Venez en faction", "§fVenez en faction", "§fVenez en faction", "§fVenez en faction'", "", CONFIRM, "§7- /mute:3m"));
                tnt.setItemMeta(tntMetadata);
                
                rottenFleshMetadata.setDisplayName(BAD_LANGUAGE);
                rottenFleshMetadata.setLore(Arrays.asList("§fUtilise des mots grossiers ou des", "§finsultes sans insulter quelqu'un.", "", "§fEx:", "§f'Sa me fait chier ce truc de merde !'", "", CONFIRM, "§7- /mute:15m"));
                rottenFlesh.setItemMeta(rottenFleshMetadata);
                
                potionMetadata.setDisplayName(PROVOCATION);
                potionMetadata.setLore(Arrays.asList("§fUn joueur provoque un autre joueur.", "", "§fEx:", "§f'ahah t'es marrant toi tu y", "§farrivera pas'", "§f'Bah vas-y insulte moi si t'es un", "§fhomme...", "", CONFIRM, "§7- /mute:10m"));
                potion.setItemMeta(potionMetadata);
                
                creeperHeadMetadata.setDisplayName(INSULT);
                creeperHeadMetadata.setLore(Arrays.asList("§fUn joueur insulte.", "", "§fEx:", "§f'C'est de la merde votre serveur'", "§f'T'es vraiment trop con'", "", CONFIRM, "§7- /mute:30m"));
                creeperHead.setItemMeta(creeperHeadMetadata);
                
                enderPearlMetadata.setDisplayName(OFFENSE_INCITEMENT);
                enderPearlMetadata.setLore(Arrays.asList("§fIncite à enfreindre les règles.", "", "§fEx:", "§f'Tout le monde met + 1'", "§f'On fait tous des alliances en SkyWars !'", "", CONFIRM, "§7- /mute:15m"));
                enderPearl.setItemMeta(enderPearlMetadata);
                
                bookMetadata.setDisplayName(CHAT_BYPASS);
                bookMetadata.setLore(Arrays.asList("§fContourne une protection de chat de façon délibérée.", "", CONFIRM, "§7- /mute:45m"));
                book.setItemMeta(bookMetadata);
                
                ironBarsMetadata.setDisplayName(FORBIDDEN_LINK);
                ironBarsMetadata.setLore(Arrays.asList("§fLien vers site interdit (porno,", "§fetc... mais sans tentative de hack).", "", CONFIRM, "§7- /ban:1d"));
                ironBars.setItemMeta(ironBarsMetadata);
                
                bannerMetadata.setDisplayName(ADS);
                bannerMetadata.setLore(Arrays.asList("§fPublicité pour un autre serveur ou", "§fservice !", "§fAttention, les citations sont autorisées !", "", "§fEx:", "", "§f'Venez sur mon serveur : ", "§f1.2.3.4.11155'", "§f'Tout le monde sur Hypixel !'", "", CONFIRM, "§7- /mute:7d"));
                banner.setItemMeta(bannerMetadata);
                
                carrotOnAStickMetadata.setDisplayName(HACK);
                carrotOnAStickMetadata.setLore(Arrays.asList("§fTentative de hack/ddos/abus d'un", "§fautre utilisateur.", "", "§fEx:", "", "§f'Gagnez de l'argent sur", "§fhttps://argent-gratuit.fr/'", "§f'Je vais te boot/ddos'", "", CONFIRM, "§7- /ban:7d"));
                carrotOnAStick.setItemMeta(carrotOnAStickMetadata);
                
                nameTagMetadata.setDisplayName(WRONG_USERNAME);
                nameTagMetadata.setLore(Arrays.asList("§fPseudonyme invalide (insultant).", "§fOu se fait passer pour quelqu'un de connu.", "", CONFIRM, "§7- /ban:1h"));
                nameTag.setItemMeta(nameTagMetadata);
                
                skeletonHeadMetadata.setDisplayName(THREAT);
                skeletonHeadMetadata.setLore(Arrays.asList("§fDe grosses menaces IRL qui peuvent", "§fréellement faire peur.", "", "§fOn parle vraiment de GROSSES", "§fmenaces: les simples 'toi t'es", "§fmort' qui partent sur un coup de rage ne comptent pas ici.", "", CONFIRM, "§7- /ban:1000d"));
                skeletonHead.setItemMeta(skeletonHeadMetadata);
                
                woodDoorMetadata.setDisplayName(BACK);
                woodDoorMetadata.setLore(Arrays.asList(BACK_TO));
                woodDoor.setItemMeta(woodDoorMetadata);
                
                inventory.setItem(0, playerSkull);
                inventory.setItem(1, paper);
                inventory.setItem(9, woodenHoe);
                inventory.setItem(10, glassBottle);
                inventory.setItem(11, zombieHead);
                inventory.setItem(12, fish);
                inventory.setItem(13, diamondSword);
                inventory.setItem(14, tnt);
                inventory.setItem(15, rottenFlesh);
                inventory.setItem(16, potion);
                inventory.setItem(17, creeperHead);
                inventory.setItem(18, enderPearl);
                inventory.setItem(19, book);
                inventory.setItem(20, ironBars);
                inventory.setItem(21, banner);
                inventory.setItem(22, carrotOnAStick);
                inventory.setItem(23, nameTag);
                inventory.setItem(24, skeletonHead);
                inventory.setItem(53, woodDoor);
                
                player.openInventory(inventory);
            }
            
            else if (itemStack.getType() == Material.IRON_SWORD)
            {                   
                inventory = Bukkit.createInventory(null, 54, Constants.INVENTORY_GAMEPLAY);
                
                playerSkullMetadata.setDisplayName("§b" + CommandSS.offlinePlayer);
                playerSkull.setItemMeta(playerSkullMetadata);
                
                ironSwordMetadata.setDisplayName(GAMEPLAY);
                ironSword.setItemMeta(ironSwordMetadata);
                
                clownFishMetadata.setDisplayName(ALLY);
                clownFishMetadata.setLore(Arrays.asList("§fAlliance entre deux joueurs ou plus", "§fdans une partie solo.", "", CONFIRM, "§7- /ban:1d"));
                clownFish.setItemMeta(clownFishMetadata);
                
                rawSalmonMetadata.setDisplayName(ALLY_1);
                rawSalmonMetadata.setLore(Arrays.asList("§fAlliance entre équipes ou plus", "§fdans une partie", "", CONFIRM, "§7- /ban:36h"));
                rawSalmon.setItemMeta(rawSalmonMetadata);
                
                dirtMetadata.setDisplayName(BUILD);
                dirtMetadata.setLore(Arrays.asList("§fConstruction incorrecte pouvant", "§fheurter la sensibilité de la", "§fmajorité.", "", "§fAttention: les pénis très basiques sont autorisés", "", CONFIRM, "§7- /ban:12h"));
                dirt.setItemMeta(dirtMetadata);
                
                leatherChestplateMetadata.setDisplayName(SKIN);
                leatherChestplateMetadata.setLore(Arrays.asList("§fSkin incorrect :", "§2>§f Sexe/Nu", "§2>§f Nazi", "§2>§f ...", "", CONFIRM, "§7- /ban:1h"));
                leatherChestplate.setItemMeta(leatherChestplateMetadata);
                
                flintAndSteelMetadata.setDisplayName(ANTI_GAMES);
                flintAndSteelMetadata.setLore(Arrays.asList("§fNe joue pas l'objectif de façon", "§fvolontaire pendant la partie.", "", CONFIRM, "§7- /ban:1d"));
                flintAndSteel.setItemMeta(flintAndSteelMetadata);
                
                woodDoorMetadata.setDisplayName(BACK);
                woodDoorMetadata.setLore(Arrays.asList(BACK_TO));
                woodDoor.setItemMeta(woodDoorMetadata);
                
                inventory.setItem(0, playerSkull);
                inventory.setItem(1, ironSword);
                inventory.setItem(9, clownFish);
                inventory.setItem(10, rawSalmon);
                inventory.setItem(11, dirt);
                inventory.setItem(12, leatherChestplate);
                inventory.setItem(13, flintAndSteel);
                inventory.setItem(53, woodDoor);
                
                player.openInventory(inventory);
            }
            
            else if (itemStack.getType() == Material.GOLDEN_APPLE)
            {
                inventory = Bukkit.createInventory(null, 54, Constants.INVENTORY_CHEAT);
                
                playerSkullMetadata.setDisplayName("§b" + CommandSS.offlinePlayer);
                playerSkull.setItemMeta(playerSkullMetadata);
                
                goldenAppleMetadata.setDisplayName(CHEAT);
                goldenApple.setItemMeta(goldenAppleMetadata);
                
                cobwebMetadata.setDisplayName(ANTI_KNOCKBACK);
                cobwebMetadata.setLore(Arrays.asList("§fUtilisation d'un anti-knockback:", "§fLe joueur ne prend pas de recul", "§florsqu'il est heurté par un joueur", "§fou un projectile.", "", CONFIRM, "§7- /ban:1000d"));
                cobweb.setItemMeta(cobwebMetadata);
                
                ironSwordCheatMetadata.setDisplayName(FORCE_FIELD);
                ironSwordCheatMetadata.setLore(Arrays.asList("§fLe joueur frappe automatiquement:", "§2>§f ForceField", "§2>§f KillAura", "§2>§f Trigger bot", "§2>§f ...", "", CONFIRM, "§7- /ban:1000d"));
                ironSwordCheat.setItemMeta(ironSwordCheatMetadata);
                
                clockMetadata.setDisplayName(TIMER);
                clockMetadata.setLore(Arrays.asList("§fLe joueur a augmenter la vitesse du", "§fjeux pour effectuer certaines", "§factions plus vite.", "§fOu il place juste des blocs plus vite.", "", CONFIRM, "§7- /ban:1000d"));
                clock.setItemMeta(clockMetadata);
                
                bowMetadata.setDisplayName(REACH);
                bowMetadata.setLore(Arrays.asList("§fLe joueur frappe de plus loin.", "", CONFIRM, "§7- /ban:1000d"));
                bow.setItemMeta(bowMetadata);
                
                stoneMetadata.setDisplayName(OTHERS);
                stoneMetadata.setLore(Arrays.asList("§fAutre mode de triche.", "", CONFIRM, "§7- /ban:1000d"));
                stone.setItemMeta(stoneMetadata);
                
                ironAxeMetadata.setDisplayName(CPS);
                ironAxeMetadata.setLore(Arrays.asList("§fNombre de clics trop élevé.", "§fCertainement du jiter, pas trop", "§félevé et variable.", "", CONFIRM, "§7- /ban:1d"));
                ironAxe.setItemMeta(ironAxeMetadata);
                
                diamondAxeMetadata.setDisplayName(CPS_1);
                diamondAxeMetadata.setLore(Arrays.asList("§fNombre de clics trop élevé.", "§fCPS très élevé et utilisation de", "§ftriche certaines !", "§2>§f 20 CPS constant", "", CONFIRM, "§7- /ban:1000d"));
                diamondAxe.setItemMeta(diamondAxeMetadata);
                
                featherMetadata.setDisplayName(FLY);
                featherMetadata.setLore(Arrays.asList("§fUtilisation d'un mode pour voler ou", "§fplaner.", "", CONFIRM, "§7- /ban:1000d"));
                feather.setItemMeta(featherMetadata);
                
                woodDoorMetadata.setDisplayName(BACK);
                woodDoorMetadata.setLore(Arrays.asList(BACK_TO));
                woodDoor.setItemMeta(woodDoorMetadata);
                
                inventory.setItem(0, playerSkull);
                inventory.setItem(1, goldenApple);
                inventory.setItem(9, cobweb);
                inventory.setItem(10, ironSwordCheat);
                inventory.setItem(11, clock);
                inventory.setItem(12, bow);
                inventory.setItem(13, stone);
                inventory.setItem(14, ironAxe);
                inventory.setItem(15, diamondAxe);
                inventory.setItem(16, feather);
                inventory.setItem(53, woodDoor);
                
                player.openInventory(inventory);
            }
            
            else if (itemStack.getType() == Material.WOOD_DOOR)
            {
                player.closeInventory();
            }   
        }
        
        else if (inventory.getName().equalsIgnoreCase(Constants.INVENTORY_MESSAGES))
        {
            event.setCancelled(true);
            
            if (itemStack.getType() == Material.WOOD_HOE)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 1m " + USELESS_MESSAGE);
            }
            
            else if (itemStack.getType() == Material.GLASS_BOTTLE)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 3m " + FALSE_INFORMATION);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == SMS)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 1m " + SMS);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == WRONG_FORMATTER)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 2m " + WRONG_FORMATTER);
            }
            
            else if (itemStack.getType() == Material.DIAMOND_SWORD)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 1m " + VANTARDISE);
            }
            
            else if (itemStack.getType() == Material.TNT)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 3m " + FLOOD);
            }
            
            else if (itemStack.getType() == Material.ROTTEN_FLESH)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 15m " + BAD_LANGUAGE);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == PROVOCATION)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 10m " + PROVOCATION);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == INSULT)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 30m " + INSULT);
            }
            
            else if (itemStack.getType() == Material.ENDER_PEARL)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 15m " + OFFENSE_INCITEMENT);
            }
            
            else if (itemStack.getType() == Material.BOOK)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 45m " + CHAT_BYPASS);
            }
            
            else if (itemStack.getType() == Material.IRON_FENCE)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 d " + FORBIDDEN_LINK);
            }

            else if (itemStack.getType() == Material.BEDROCK)
            {
                player.performCommand("ss-mute " + CommandSS.offlinePlayer + " 7d " + ADS);
            }
            
            else if (itemStack.getType() == Material.CARROT_STICK)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 7 d " + HACK);
            }
            
            else if (itemStack.getType() == Material.NAME_TAG)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 h " + WRONG_USERNAME);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == THREAT)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + THREAT);
            }
            
            else if (itemStack.getType() == Material.WOOD_DOOR)
            {
                player.openInventory(CommandSS.INVENTORY_SS);
            }
        }
        
        else if (inventory.getName().equalsIgnoreCase(Constants.INVENTORY_GAMEPLAY))
        {
            event.setCancelled(true);
            
            if (itemStack.getItemMeta().getDisplayName() == ALLY)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 d " + ALLY);
            }
            
            else if (itemStack.getItemMeta().getDisplayName() == ALLY_1)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 36 h " + ALLY_1);
            }
            
            else if (itemStack.getType() == Material.DIRT)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 12 h " + BUILD);
            }
            
            else if (itemStack.getType() == Material.LEATHER_CHESTPLATE)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 h " + SKIN);
            }
            
            else if (itemStack.getType() == Material.FLINT_AND_STEEL)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 d " + ANTI_GAMES);
            }
            
            else if (itemStack.getType() == Material.WOOD_DOOR)
            {
                player.openInventory(CommandSS.INVENTORY_SS);
            }
        }
        
        else if (inventory.getName().equalsIgnoreCase(Constants.INVENTORY_CHEAT))
        {   
            event.setCancelled(true);
            
            if (itemStack.getType() == Material.WEB)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + ANTI_KNOCKBACK);
            }
            
            else if (itemStack.getType() == Material.IRON_SWORD)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + FORCE_FIELD);
            }
            
            else if (itemStack.getType() == Material.WATCH)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + TIMER);
            }
            
            else if (itemStack.getType() == Material.BOW)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + REACH);
            }
            
            else if (itemStack.getType() == Material.STONE)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + OTHERS);
            }
            
            else if (itemStack.getType() == Material.IRON_AXE)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1 d " + CPS);
            }
            
            else if (itemStack.getType() == Material.DIAMOND_AXE)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + CPS_1);
            }
            
            else if (itemStack.getType() == Material.FEATHER)
            {
                player.performCommand("ss-ban " + CommandSS.offlinePlayer + " 1000 d " + FLY);
            }
            
            else if (itemStack.getType() == Material.WOOD_DOOR)
            {
                player.openInventory(CommandSS.INVENTORY_SS);
            }
        }
    }
    
    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        PlayerData playerData = new PlayerData(player.getUniqueId());
        
        if (playerData.isTempMuted())
        {
            if (playerData.getTempMuteMilliseconds().longValue() <= System.currentTimeMillis())
            {
                playerData.setUnTempMuted();
            }
            
            else
            {
                event.setCancelled(true);
                player.sendMessage("§6[SS-Mute] §cVous êtes réduit au silence jusqu'au §6" + (new SimpleDateFormat("dd.MM.yyyy")).format(playerData.getTempMuteMilliseconds()) + " §cà §6" + (new SimpleDateFormat("HH:mm")).format(playerData.getTempMuteMilliseconds()) + " §cpour §6" + playerData.getTempMuteReason());
            }
        }
    }
}