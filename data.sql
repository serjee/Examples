CREATE DATABASE coins_analyzer DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

/* Coins info */
DROP TABLE IF EXISTS `coins_analyzer`.`coins_info`;
CREATE TABLE IF NOT EXISTS `coins_analyzer`.`coins_info` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `cmc_id` VARCHAR(50) NOT NULL COMMENT 'CoinMarketCap Id',
  `name` VARCHAR(100) NOT NULL COMMENT 'coin name',
  `symbol` VARCHAR(20) NOT NULL COMMENT 'coin symbol',
  `max_supply` DECIMAL(36,10) NULL COMMENT 'coin max supply'
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE (`cmc_id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/* Coins info */
DROP TABLE IF EXISTS `coins_analyzer`.`coins_market`;
CREATE TABLE IF NOT EXISTS `coins_analyzer`.`coins_market` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `coin_id` INT(11) UNSIGNED NOT NULL COMMENT 'Coin Id',
  `price` DECIMAL(36,12) NULL,
  `price_change` DECIMAL(36,12) NULL,
  `price_change_per` DECIMAL(18,2) NULL,
  `volume` DECIMAL(36,12) NULL,
  `volume_change` DECIMAL(36,12) NULL,
  `volume_changepr` DECIMAL(18,2) NULL,
  `mc` DECIMAL(36,10) NULL,
  `mc_change` DECIMAL(36,10) NULL,
  `mc_changepr` DECIMAL(36,10) NULL,
  `av_supply` DECIMAL(36,10) NULL,
  `av_supply_change` DECIMAL(36,10) NULL,
  `av_supply_changepr` DECIMAL(18,2) NULL,
  `tt_supply` DECIMAL(36,10) NULL,
  `tt_supply_change` DECIMAL(36,10) NULL,
  `tt_supply_changepr` DECIMAL(18,2) NULL,
  `cmc_updated` INT(11) UNSIGNED NOT NULL,

  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;