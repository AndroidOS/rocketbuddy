package com.casa.azul.rocketboy.model

data class Core(
    val core_serial: String,
    val flight: Int,
    val block: Int,
    val gridfins: Boolean,
    val legs: Boolean,
    val reused: Boolean,
    val land_success: Object,
    val landing_intent: Boolean,
    val landing_type: Object,
    val landing_vehicle: Object
)

data class FirstStage(
    val cores: List<Core>
)

data class OrbitParams(
    val reference_system: String,
    val regime: String,
    val longitude: Int,
    val semi_major_axis_km: Object,
    val eccentricity: Object,
    val periapsis_km: Object,
    val apoapsis_km: Object,
    val inclination_deg: Object,
    val period_min: Object,
    val lifespan_years: Int,
    val epoch: Object,
    val mean_motion: Object,
    val raan: Object,
    val arg_of_pericenter: Object,
    val mean_anomaly: Object
)

data class Payload(
    val payload_id: String,
    val norad_id: List<Object>,
    val reused: Boolean,
    val customers: List<String>,
    val nationality: String,
    val manufacturer: String,
    val payload_type: String,
    val payload_mass_kg: Int,
    val payload_mass_lbs: Double,
    val orbit: String,
    val orbit_params: OrbitParams
)

data class SecondStage(
    val block: Int,
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
    val flight_club: Object
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
    val reddit_recovery: Object,
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
    val mission_id: List<Object>,
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
    val timeline: Object,
    val crew: Object,
    val last_wiki_update: Object,
    val is_date_from_wiki: Object
)
