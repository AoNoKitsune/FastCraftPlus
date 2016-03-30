package co.kepler.fastcraftplus.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.*;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * A wrapper class for a CraftingInventory
 */
public class CraftingInvWrapper implements CraftingInventory {
    private final Inventory craftingInv;
    private Recipe recipe;

    /**
     * Create a new instance of CraftingInvWrapper.
     *
     * @param owner The owner of the crafting inventory.
     */
    public CraftingInvWrapper(InventoryHolder owner) {
        craftingInv = Bukkit.createInventory(owner, InventoryType.WORKBENCH);
    }

    @Override
    public ItemStack getResult() {
        return craftingInv.getItem(0);
    }

    @Override
    public void setResult(ItemStack itemStack) {
        craftingInv.setItem(0, itemStack);
    }

    @Override
    public ItemStack[] getMatrix() {
        ItemStack[] matrix = new ItemStack[9];
        System.arraycopy(getContents(), 1, matrix, 0, matrix.length);
        return matrix;
    }

    @Override
    public void setMatrix(ItemStack[] itemStacks) {
        ItemStack[] contents = getContents();
        System.arraycopy(itemStacks, 0, contents, 1, itemStacks.length);
        setContents(contents);
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Set this crafting inventory's recipe.
     *
     * @param recipe The crafting inventory's new recipe.
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int getSize() {
        return craftingInv.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return craftingInv.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        craftingInv.setMaxStackSize(i);
    }

    @Override
    public String getName() {
        return craftingInv.getName();
    }

    @Override
    public ItemStack getItem(int i) {
        return craftingInv.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        craftingInv.setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return craftingInv.addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return craftingInv.removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return craftingInv.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        craftingInv.setContents(itemStacks);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public boolean contains(int i) {
        return craftingInv.contains(i);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return craftingInv.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return craftingInv.contains(itemStack);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public boolean contains(int i, int i1) {
        return craftingInv.contains(i, i1);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return craftingInv.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return craftingInv.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return craftingInv.containsAtLeast(itemStack, i);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public HashMap<Integer, ? extends ItemStack> all(int i) {
        return craftingInv.all(i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return craftingInv.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return craftingInv.all(itemStack);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public int first(int i) {
        return craftingInv.first(i);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return craftingInv.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return craftingInv.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return craftingInv.firstEmpty();
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public void remove(int i) {
        craftingInv.remove(i);
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        craftingInv.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        craftingInv.remove(itemStack);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public void clear(int i) {
        craftingInv.remove(i);
    }

    @Override
    public void clear() {
        craftingInv.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return craftingInv.getViewers();
    }

    @Override
    public String getTitle() {
        return craftingInv.getTitle();
    }

    @Override
    public InventoryType getType() {
        return craftingInv.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return craftingInv.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return craftingInv.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return craftingInv.iterator(i);
    }
}
