package com.casa.azul.rocketboy.model


data class Core(
    val core_serial: String,
    val flight: Int,
    val block: Int,
    val gridfins: Boolean,
    val legs: Boolean,
    val reused: Boolean,
    val land_success: Any,
    val landing_intent: Boolean,
    val landing_type: Any,
    val landing_vehicle: Any
)


data class FirstStage(
    val cores: List<Core>
)


data class OrbitParams(
    val reference_system: String,
    val regime: String,
    val longitude: Double,
    val semi_major_axis_km: Any,
    val eccentricity: Any,
    val periapsis_km: Any,
    val apoapsis_km: Any,
    val inclination_deg: Any,
    val period_min: Any,
    val lifespan_years: Double,
    val epoch: Any,
    val mean_motion: Any,
    val raan: Any,
    val arg_of_pericenter: Any,
    val mean_anomaly: Any
)


data class Payload(
    val payload_id: String,
    val norad_id: List<Any>,
    val reused: Boolean,
    val customers: List<String>,
    val nationality: String,
    val manufacturer: String,
    val payload_type: String,
    val payload_mass_kg: Double,
    val payload_mass_lbs: Double,
    val orbit: String,
    val orbit_params: OrbitParams
)


data class SecondStage(
    val block: Double,
    val payloads: List<Payload>
)


data class Fairings(
    val reused: Boolean,
    val recovery_attempt: Boolean,
    val recovered: Boolean,
    val ship: String
)


data class Rocket(
    val rocket_id: String,
    val rocket_name: String,
    val rocket_type: String,
    val first_stage: FirstStage,
    val second_stage: SecondStage,
    val airings: Fairings
)


data class Telemetry(
    val flight_club: Any
)


data class LaunchSite(
    val site_id: String,
    val site_name: String,
    val site_name_long: String
)


data class Links(
    val mission_patch: String,
    val mission_patch_small: String,
    val reddit_campaign: String,
    val reddit_launch: String,
    val reddit_recovery: Any,
    val reddit_media: String,
    val presskit: String,
    val article_link: String,
    val wikipedia: String,
    val video_link: String,
    val youtube_id: String,
    val flickr_images: List<String>
)


data class Mission(
    val flight_number: Int,
    val mission_name: String,
    val mission_id: List<Any>,
    val launch_year: String,
    val launch_date_unix: Int,
    val launch_date_utc: String,
    val launch_date_local: String,
    val is_tentative: Boolean,
    val tentative_max_precision: String,
    val tbd: Boolean,
    val launch_window: Int,
    val rocket: Rocket,
    val ships: List<String>,
    val telemetry: Telemetry,
    val launch_site: LaunchSite,
    val launch_success: Boolean,
    val links: Links,
    val details: String,
    val upcoming: Boolean,
    val static_fire_date_utc: String,
    val static_fire_date_unix: Int,
    val timeline: Any,
    val crew: Any,
    val last_wiki_update: Any,
    val is_date_from_wiki: Any
) 
