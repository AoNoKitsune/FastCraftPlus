package co.kepler.fastcraftplus.craftgui;

import co.kepler.fastcraftplus.gui.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

/**
 * The FastCraft crafting GUI.
 */
public class GUIFastCraft extends GUI {
    private static final ChatColor BUTTON_NAME_COLOR = ChatColor.GREEN;

    private final GUILayoutCrafting craftLayout;
    private final Player player;

    private final GUIButton btnPagePrev;
    private final GUIButton btnPageNext;
    private final GUIButton btnMultiCraft;
    private final GUIButton btnWorkbench;
    private final GUIButtonGlowing btnTabCrafting;
    private final GUIButtonGlowing btnTabArmor;
    private final GUIButtonGlowing btnTabRepair;
    private final GUIButtonGlowing btnTabFireworks;

    /**
     * Create a new instance of a FastCraft GUI.
     *
     * @param player The player who will be shown this GUI.
     */
    public GUIFastCraft(Player player) {
        super("FastCraft", 6); // TODO Localize

        this.player = player;

        craftLayout = new GUILayoutCrafting();
        setLayout(craftLayout);

        // Create buttons TODO Localize
        GUILayout navbar = craftLayout.getLayoutNavbar();

        btnPagePrev = new GUIButton(new GUIItemBuilder(Material.ARROW)
                .setDisplayName(BUTTON_NAME_COLOR + "Previous Page")
                .setHideInfo(true).build());
        btnPagePrev.setClickAction(info -> btnPagePrevClick(info));
        navbar.setButton(0, btnPagePrev);

        btnPageNext = new GUIButton(new GUIItemBuilder(Material.ARROW)
                .setDisplayName(BUTTON_NAME_COLOR + "Next Page")
                .setHideInfo(true).build());
        btnPageNext.setClickAction(info -> btnPageNextClick(info));
        navbar.setButton(8, btnPageNext);

        btnMultiCraft = new GUIButton(new GUIItemBuilder(Material.ANVIL)
                .setLore("Craft Amount").build());
        btnMultiCraft.setClickAction(info -> btnMultiCraftClick(info));
        navbar.setButton(6, btnMultiCraft);

        btnWorkbench = new GUIButton(new GUIItemBuilder(Material.WORKBENCH)
                .setLore("Open Crafting Grid").build());
        btnWorkbench.setClickAction(info -> btnWorkbenchClick(info));
        navbar.setButton(7, btnWorkbench);

        btnTabCrafting = new GUIButtonGlowing(new GUIItemBuilder(Material.STICK)
                .setDisplayName(BUTTON_NAME_COLOR + "Crafting").build());
        btnTabCrafting.setClickAction(info -> btnTabCraftingClick(info));
        btnTabCrafting.setGlowing(true);
        navbar.setButton(1, btnTabCrafting);

        btnTabArmor = new GUIButtonGlowing(new GUIItemBuilder(Material.LEATHER_CHESTPLATE)
                .setDisplayName(BUTTON_NAME_COLOR + "Dyed Armor").build());
        btnTabArmor.setClickAction(info -> btnTabArmorClick(info));
        navbar.setButton(2, btnTabArmor);

        btnTabRepair = new GUIButtonGlowing(new GUIItemBuilder(Material.IRON_PICKAXE)
                .setDisplayName(BUTTON_NAME_COLOR + "Repair Items").build());
        btnTabRepair.setClickAction(info -> btnTabRepairClick(info));
        navbar.setButton(3, btnTabRepair);

        btnTabFireworks = new GUIButtonGlowing(new GUIItemBuilder(Material.FIREWORK)
                .setDisplayName(BUTTON_NAME_COLOR + "Fireworks").build());
        btnTabFireworks.setClickAction(info -> btnTabFireworksClick(info));
        navbar.setButton(4, btnTabFireworks);



        // Update the GUI's layout
        updateLayout();
    }

    @Override
    public void show(Player... players) {
        assert players.length == 1 && players[0].equals(player) :
                "FastCraft GUI can only be shown to its associated player";
        super.show(players);
    }

    /**
     * Open the GUIFastCraft for its associated player.
     */
    public void show() {
        show(player);
    }

    @Override
    public void onClose(HumanEntity closedBy) {
        if (getInventory().getViewers().isEmpty()) {
            dispose();
        }
    }

    private void showTab(CraftingTab tab) {
        btnTabCrafting.setGlowing(tab == CraftingTab.CRAFTING);
        btnTabArmor.setGlowing(tab == CraftingTab.ARMOR);
        btnTabRepair.setGlowing(tab == CraftingTab.REPAIR);
        btnTabFireworks.setGlowing(tab == CraftingTab.FIREWORKS);

        craftLayout.showLayout(tab);
        updateLayout();
    }


    private void btnPagePrevClick(GUIButton.ButtonClickInfo info) {
        System.out.println("A");
    }

    private void btnPageNextClick(GUIButton.ButtonClickInfo info) {
        System.out.println("B");
    }

    private void btnMultiCraftClick(GUIButton.ButtonClickInfo info) {

    }

    private void btnWorkbenchClick(GUIButton.ButtonClickInfo info) {
        player.openWorkbench(null, false);
    }

    private void btnTabCraftingClick(GUIButton.ButtonClickInfo info) {
        showTab(CraftingTab.CRAFTING);
    }

    private void btnTabArmorClick(GUIButton.ButtonClickInfo info) {
        showTab(CraftingTab.ARMOR);
    }

    private void btnTabRepairClick(GUIButton.ButtonClickInfo info) {
        showTab(CraftingTab.REPAIR);
    }

    private void btnTabFireworksClick(GUIButton.ButtonClickInfo info) {
        showTab(CraftingTab.FIREWORKS);
    }
}