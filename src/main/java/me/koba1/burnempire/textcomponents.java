package me.koba1.burnempire;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.Listener;

public class textcomponents implements Listener {

    public TextComponent playeradd() {
        TextComponent tc = new TextComponent("§b/p add <név>§7 - Játékos hozzáadása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p add "));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oAmikor offline vagy\nnem fog tudni építeni\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent playertrust() {
        TextComponent tc = new TextComponent("§b/p trust <név>§7 - Játékos megbízása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p trust "));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oAmikor offline vagy\nakkor is fog tudni építeni\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent claim() {
        TextComponent tc = new TextComponent("§b/p claim§7 - Szabad telek lefoglalása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p c"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz,\nazt fogja odaadni, ha még nem foglalt\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent clear() {
        TextComponent tc = new TextComponent("§b/p clear§7 - Telked visszaállítása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p clear"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz,\nazt fogja visszaállítani\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent delete() {
        TextComponent tc = new TextComponent("§b/p delete§7 - Telked törlése)");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p delete"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz,\nazt fogja törölni\nVisszaállítást nem vállalunk!\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent setOwner() {
        TextComponent tc = new TextComponent("§b/p setowner <név>§7 - Telked átadása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p setowner "));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oTelked átadása egy másik játékosnak\nElrontott átadásért felelősséget nem vállalunk!\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent merge() {
        TextComponent tc = new TextComponent("§b/p merge§7 - Telkek összekötése");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p merge"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz\nés amelyik telekre nézel\naz fog összekötődni\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent unlink() {
        TextComponent tc = new TextComponent("§b/p unlink§7 - Összekötés szétszedése");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p unlink"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz\nés amelyik telekre nézel\nazt fogja szétszedni\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent auto() {
        TextComponent tc = new TextComponent("§b/p auto§7 - Telek igénylése");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p auto"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oEgy random telket fog neked adni\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent home() {
        TextComponent tc = new TextComponent("§b/p home <szám>§7 - Telked(id)re teleportálás");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p h"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oEgy telek esetén nem kell\nszámot írni a parancsba\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent toggles() {
        TextComponent tc = new TextComponent("§b/p toggle titles§7 - Feliratok kikapcsolása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p toggle titles"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oAmikor belépsz egy telekre,\nazt a feliratot kapcsolja ki\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent setbime() {
        TextComponent tc = new TextComponent("§b/p setbiome <biome>§7 - Biome beállítása");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/p setbiome "));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oJelenlegi telken, amelyiken állsz,\nazon állítja be a biomot\n\n§c§oKiegészítéshez kattints ide!").create()));
        return tc;
    }

    public TextComponent nexthelp1() {
        TextComponent tc = new TextComponent();
        tc.setText("§7§m+------§8§m------+§7§l [ §b§lOldal: 1 §7§l] ");

        TextComponent tc2 = new TextComponent("§b§lKövetkező §7§l>>>");
        tc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helps 2"));
        tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oKattints ide a továbblépéshez!").create()));
        tc.addExtra(tc2);
        return tc;
    }

    public TextComponent nexthelp2() {
        TextComponent tc = new TextComponent("§7§l<<< §b§lElőző§7§l");
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/helps 1"));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§oKattints ide a visszalépéshez!").create()));

        TextComponent tc2 = new TextComponent();
        tc2.setText(" [ §b§lOldal: 2 §7§l] §8§m+------§7§m------+");

        tc.addExtra(tc2);
        return tc;
    }
}
