package jsclub.codefest2024.socket.data.Weapons;

public class WeaponModel {
    private String name;
    private String type;
    private int size;
    private int point;
    private int rare;
    private int damage;
    private int obstacleDamage;
    private Double stunDuration;
    private int knockbackDistance;
    private int cooldown;
    private int capacity;
    private int bulletSpeed;
    private int range;
    private int explosionRadius;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setObstacleDamage(int obstacleDamage) {
        this.obstacleDamage = obstacleDamage;
    }

    public void setStunDuration(Double stunDuration) {
        this.stunDuration = stunDuration;
    }

    public void setKnockbackDistance(int knockbackDistance) {
        this.knockbackDistance = knockbackDistance;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getPoint() {
        return point;
    }

    public int getRare() {
        return rare;
    }

    public int getDamage() {
        return damage;
    }

    public int getObstacleDamage() {
        return obstacleDamage;
    }

    public Double getStunDuration() {
        return stunDuration;
    }

    public int getKnockbackDistance() {
        return knockbackDistance;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public int getRange() {
        return range;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }
}
