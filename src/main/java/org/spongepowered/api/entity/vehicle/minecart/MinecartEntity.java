/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.entity.vehicle.minecart;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.math.vector.Vector3d;

/**
 * Represents a MinecartEntity entity.
 */
public interface MinecartEntity extends Entity {

    /**
     * Gets whether or not the minecart is currently on a valid rail block.
     *
     * @return If the cart is on a rail
     */
    default boolean isOnRail() {
        return require(Keys.MINECART_IS_ON_RAIL);
    }

    /**
     * Gets the absolute maximum speed that this cart is allowed to travel at.
     *
     * <p>The default value is 0.4.</p>
     *
     * @return The maximum speed
     */
    default double getSwiftness() {
        return require(Keys.MINECART_SWIFTNESS);
    }

    /**
     * Sets the absolute maximum speed that this cart is allowed to travel at.
     *
     * <p>The default value is 0.4.</p>
     *
     * @param swiftness The new maximum speed
     */
    default void setSwiftness(double swiftness) {
        offer(Keys.MINECART_SWIFTNESS, swiftness);
    }

    /**
     * Gets the maximum speed that this cart is allowed to travel at the instant
     * this method is called.
     *
     * <p>This differs from {@link Minecart#getSwiftness()} in that its value is
     * affected by the block/rail beneath the cart. However, it is still
     * impacted and limited by the cart's swiftness.</p>
     *
     * @return The maximum speed at which the minecart may travel at the instant
     *     this method is called
     */
    default double getPotentialMaxSpeed() {
        return require(Keys.MINECART_POTENTIAL_MAX_SPEED);
    }

    /**
     * Gets whether or not the minecart slows down faster without a passenger.
     *
     * @return If the cart slows when empty
     */
    default boolean doesSlowWhenEmpty() {
        return require(Keys.MINECART_SLOW_WHEN_EMPTY);
    }

    /**
     * Sets whether or not the minecart slows down faster without a passenger.
     *
     * @param slowWhenEmpty If the cart should slow when empty
     */
    default void setSlowWhenEmpty(boolean slowWhenEmpty) {
        offer(Keys.MINECART_SLOW_WHEN_EMPTY, slowWhenEmpty);
    }

    /**
     * Gets the velocity modifier applied when the minecart is airborne.
     *
     * @return Airborne velocity modifier
     */
    default Vector3d getAirborneVelocityMod() {
        return require(Keys.MINECART_AIRBORNE_VELOCITY_MODIFIER);
    }

    /**
     * Sets the velocity modifier applied when the minecart is airborne.
     *
     * @param airborneVelocityMod The new airborne velocity modifier
     */
    default void setAirborneVelocityMod(Vector3d airborneVelocityMod) {
        offer(Keys.MINECART_AIRBORNE_VELOCITY_MODIFIER, airborneVelocityMod);
    }

    /**
     * Gets the velocity modifier applied when the minecart is not on rails.
     *
     * @return Derailed velocity modifier
     */
    default Vector3d getDerailedVelocityMod() {
        return require(Keys.MINECART_DERAILED_VELOCITY_MODIFIER);
    }

    /**
     * Sets the velocity modifier applied when the minecart is not on rails.
     *
     * @param derailedVelocityMod The new derailed velocity modifier
     */
    default void setDerailedVelocityMod(Vector3d derailedVelocityMod) {
        offer(Keys.MINECART_DERAILED_VELOCITY_MODIFIER, derailedVelocityMod);
    }

}