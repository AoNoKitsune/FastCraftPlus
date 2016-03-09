package co.kepler.fastcraftplus.gui;

import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * A button for the GUI that players can interact with.
 */
public abstract class GUIButton {
    private ItemStack item;

    /**
     * Create a new GUIButton.
     * @param item The item that represents the button.
     */
    public GUIButton(ItemStack item) {
        this.item = item;
    }

    /**
     * Get the item that represents this button.
     * @return Returns the item that represents this button.
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * See if this button is visible in the GUI.
     * @return Returns true if the button should be visible in the GUI.
     */
    public boolean isVisible(GUILayout layout) {
        return true;
    }

    /**
     * Get the sound to be played when the button is clicked
     */
    public Sound getClickSound() {
        return Sound.UI_BUTTON_CLICK;
    }

    /**
     * Called when the button is clicked.
     * @param layout The layout in which the button was clicked.
     * @param invEvent The inventory event triggered by the click.
     */
    public abstract void onClick(GUILayout layout, InventoryClickEvent invEvent);
}